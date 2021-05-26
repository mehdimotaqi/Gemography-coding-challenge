package com.gemography.coding.challenge.ui.githubRepository

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gemography.coding.challenge.R
import com.gemography.coding.challenge.data.network.entities.ItemsItem
import com.gemography.coding.challenge.utils.inflate
import com.squareup.picasso.Picasso

class RepositoryAdapter(
    private val itemList: List<ItemsItem?>
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>(){

    inner class RepositoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = parent.inflate(R.layout.repository_item_view)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.repo_name).text = itemList[position]?.fullName
        holder.itemView.findViewById<TextView>(R.id.repo_description).text = itemList[position]?.description
        holder.itemView.findViewById<TextView>(R.id.repo_owner_name).text = itemList[position]?.owner?.login
        Picasso.get().load(itemList.get(position)?.owner?.avatarUrl)
            .into(holder.itemView.findViewById<ImageView>(R.id.owner_repo_avatar))
        holder.itemView.findViewById<TextView>(R.id.repo_number_stars).text = itemList[position]?.stargazersCount.toString()
    }

    override fun getItemCount(): Int{
        return if (!itemList.isNullOrEmpty()){
            itemList.size
        }else{
            0
        }
    }
}