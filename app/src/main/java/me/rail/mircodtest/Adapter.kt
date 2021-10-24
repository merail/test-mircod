package me.rail.mircodtest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import me.rail.mircodtest.databinding.ItemCandidateBinding
import me.rail.mircodtest.service.Candidate

class Adapter(private val context: Context, private val items: List<Candidate>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCandidateBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.itemView = item

        item.image_url?.let {
            holder.binding.image.load(it) {
                placeholder(R.drawable.placegolder)
            }
        }

        item.imageUrl?.let {
            holder.binding.image.load(it) {
                placeholder(R.drawable.placegolder)
            }
        }
    }

    class ViewHolder(val binding: ItemCandidateBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return items.size
    }
}