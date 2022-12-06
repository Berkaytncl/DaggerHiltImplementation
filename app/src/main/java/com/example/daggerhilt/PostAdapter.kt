package com.example.daggerhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter: RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var liveData: List<Post>? = null

    fun setList(data: List<Post>){
        this.liveData = data
    }

    class ViewHolder(view: View):  RecyclerView.ViewHolder(view) {

        private val titleText: TextView = view.findViewById(R.id.title)
        private val bodyText: TextView = view.findViewById(R.id.body)

        fun bindItems(post: Post) {
            titleText.text = post.title
            bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(liveData!![position])
    }

    override fun getItemCount() = liveData?.size ?: 0
}