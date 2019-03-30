package com.josecm.cleanarchitectureapp.presentationlayer.components.recyclercomponent.base


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Adapter parameterized with the items and holder
 * @param itemList list that contains all different BaseViewTypeItem
 * @param callback callback that will return the actionView with his data
 */
abstract class BaseViewTypeAdapter<T: BaseViewTypeItem, VH: BaseViewTypeHolder<T, A>, A: ActionView>(var itemList: MutableList<T>?, var callback: (A) -> Unit): RecyclerView.Adapter<VH>() {

    /**
     * method for build the holder by viewType
     * @param viewType viewType of item
     * @param view inflate view with for build viewHolder
     */
    abstract fun getHolder(viewType: Int, view: View): VH

    /**
     * method that return the layout for each viewType
     * @param viewType viewType of item
     */
    abstract fun getLayoutResourceIdByViewType(viewType: Int): Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = getHolder(viewType, LayoutInflater.from(parent.context).inflate(getLayoutResourceIdByViewType(viewType), parent, false))
    override fun getItemCount(): Int = itemList?.size ?: 0
    override fun getItemViewType(position: Int): Int {
        return if (itemList?.isNotEmpty() == true) {
            getIdViewTypeByItem(itemList!![position])

        } else {
            BaseViewTypeItem.UNKNOWN
        }
    }

    /**
     * Method that return viewType for each kind of item. Can override if wants another way to get itemViewId
     */
    open fun getIdViewTypeByItem(item: T) = item.viewTypeId


    override fun onBindViewHolder(holder: VH, position: Int) = holder.onBind(itemList!![position], callback)


    //TODO make methods for add elements
    open fun refreshData(itemList: List<T>) {
        this.itemList?.clear()
        this.itemList?.addAll(itemList)
        notifyDataSetChanged()
    }

    /*fun addItem(viewTypeRow: BaseViewTypeItem) { //TODO do with diffs like baseAdapter
        val item = itemList.firstOrNull { it.viewTypeId == viewTypeRow.viewTypeId }
        item?.let {
            itemList[itemList.indexOf(item)] = viewTypeRow
            notifyItemChanged(itemList.indexOf(item))
        } ?: run {
            this.itemList.add(viewTypeRow)
            notifyItemInserted(itemList.lastIndex)
        }
    }*/
}