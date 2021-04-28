package com.example;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class MyDiffUtilCallbackJava extends DiffUtil.ItemCallback<IModel> {

	@Override public boolean areItemsTheSame(@NonNull IModel oldItem, @NonNull IModel newItem) {
		if (oldItem instanceof Model && newItem instanceof Model) {
			Model model1 = (Model)oldItem;
			Model model2 = (Model)newItem;
			return model1.getId().equals(model2.getId());
		}
		return false;
	}
	@Override public boolean areContentsTheSame(@NonNull IModel oldItem, @NonNull IModel newItem) {
		if (oldItem instanceof Model && newItem instanceof Model) {
			return oldItem.equals(newItem);
		}
		return false;
	}
}
