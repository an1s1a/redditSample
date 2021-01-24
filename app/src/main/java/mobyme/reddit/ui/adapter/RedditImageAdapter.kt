package mobyme.reddit.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mobyme.reddit.data.model.entity.RedditImage
import mobyme.reddit.databinding.ImageItemBinding

class RedditImageAdapter(val clickListener: RedditImageClickListener) : ListAdapter<RedditImage,
        RedditImageAdapter.ViewHolder>(ImageDiffCallback()) {

    class ViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RedditImage, clickListener: RedditImageClickListener) {
            Log.e("RedditImageAdapter", "bind() item value $item")
            binding.redditImage = item
            binding.clickListener = clickListener
            Glide.with(itemView.context)
                .load(item.thumbnail)
                .into(binding.imageView)
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ImageItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}

class ImageDiffCallback : DiffUtil.ItemCallback<RedditImage>() {
    override fun areItemsTheSame(oldItem: RedditImage, newItem: RedditImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RedditImage, newItem: RedditImage): Boolean {
        return oldItem == newItem
    }
}

class RedditImageClickListener(val clickListener: (redditImage: RedditImage) -> Unit) {
    fun onClick(redditImage: RedditImage) = clickListener(redditImage)
}