package com.borisov.studentapplication.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.borisov.studentapplication.R
import com.borisov.studentapplication.databinding.HomeWorkItemBinding
import com.borisov.studentapplication.domain.models.HomeWork
import com.borisov.studentapplication.utils.click
import com.borisov.studentapplication.utils.dayLeftFrom
import com.borisov.studentapplication.utils.setData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * @author Borisov Andrey on 04.07.2022
 **/

class HomeWorkViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: HomeWorkItemBinding by viewBinding()

    fun bind(homeWork: HomeWork, delegate: HomeWorkAdapter.Delegate?) {
        with(viewBinding) {
            title.text = homeWork.title
            root.click { delegate?.onHomeWorkItemPicked(homeWork) }
            work.text = homeWork.work
            deadLine.setData(dayLeftFrom(homeWork.deadLine))

            Glide.with(icon)
                .load(homeWork.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)

            Glide.with(iconOne)
                .load(homeWork.tagIconOne)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconOne)

            Glide.with(iconTwo)
                .load(homeWork.tagIconTwo)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconTwo)
        }
    }

    companion object {
        const val DELAY = 800
    }
}