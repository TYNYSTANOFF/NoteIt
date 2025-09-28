package com.example.noteit.ui.board.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteit.data.model.BoardModel
import com.example.noteit.databinding.ItemBoardBinding
import com.example.noteit.ui.loadImage

class BoardAdapter(
    val list: ArrayList<BoardModel>, val onStart: () -> Unit, val onSkip: () -> Unit
) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BoardViewHolder, position: Int
    ) {

        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class BoardViewHolder(
        private val binding: ItemBoardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(boardModel: BoardModel) {
            binding.tvText.text = boardModel.desc
            binding.tvTextTitle.text = boardModel.title
            binding.ivLottie.loadImage(boardModel.img)
            if (adapterPosition != list.size - 1) {
                binding.tvSkip.setOnClickListener {
                    onSkip()
                }
                binding.btnStart.visibility = View.GONE
            } else {
                binding.tvSkip.visibility = View.GONE
                binding.btnStart.setOnClickListener {
                    onStart()
                }
            }
        }
    }
}
