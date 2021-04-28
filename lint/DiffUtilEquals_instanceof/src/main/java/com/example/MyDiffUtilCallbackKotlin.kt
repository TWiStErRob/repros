package com.example

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtilCallbackKotlin : DiffUtil.ItemCallback<IModel>() {

    override fun areItemsTheSame(
        oldItem: IModel,
        newItem: IModel
    ): Boolean =
        oldItem is Model && newItem is Model && oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: IModel,
        newItem: IModel
    ): Boolean =
        oldItem is Model && newItem is Model && oldItem == newItem
}
