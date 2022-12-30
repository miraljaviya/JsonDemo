package com.example.jsondemo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.jsondemo.Data.Photos
import com.example.jsondemo.databinding.EachRowBinding
import javax.inject.Inject

class PhotosAdapter @Inject constructor(): PagingDataAdapter<Photos,PhotosAdapter.PhotosViewHolder>(Diff()) {


    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val dogs = getItem(position)
        if(dogs!= null){
            holder.binds(dogs)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder  =
        PhotosViewHolder(EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    class PhotosViewHolder(private val binding:EachRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun binds(photos:Photos){
            binding.apply {
                image.load(photos.thumbnailUrl)
                name.text = photos.title

            }
        }
    }

    class Diff : DiffUtil.ItemCallback<Photos>(){
        override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean  =
            oldItem.thumbnailUrl == newItem.thumbnailUrl

        override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean =
            oldItem == newItem
    }
}