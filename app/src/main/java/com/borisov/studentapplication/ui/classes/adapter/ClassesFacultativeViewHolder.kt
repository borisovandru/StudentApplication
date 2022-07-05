package com.borisov.studentapplication.ui.classes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.borisov.studentapplication.R
import com.borisov.studentapplication.databinding.ClassesFacultativeItemBinding
import com.borisov.studentapplication.domain.models.Facultative
import com.borisov.studentapplication.utils.click
import com.borisov.studentapplication.utils.setPointBackground
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class ClassesFacultativeViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: ClassesFacultativeItemBinding by viewBinding()

    fun bind(lesson: Facultative, delegate: Adapter.Delegate?) {
        with(viewBinding) {
            title.text = lesson.title
            date.text = lesson.scheduler.toString()
            teacher.text = String.format(TEACHER_STRING_TEMPLATE, lesson.teacher)
            description.text = lesson.description
            circle.setPointBackground(lesson.isTop)

            Glide.with(icon)
                .load(lesson.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)

            Glide.with(tagIconOne)
                .load(lesson.tagIconOne)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(tagIconOne)

            Glide.with(tagIconTwo)
                .load(lesson.tagIconTwo)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(tagIconTwo)

            Glide.with(tagIconThree)
                .load(lesson.tagIconThree)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(tagIconThree)

            root.click { delegate?.onLessonItemPicked(lesson) }
        }
    }

    companion object {
        const val DELAY = 800
        const val TEACHER_STRING_TEMPLATE = "Учитель: %s"
    }
}