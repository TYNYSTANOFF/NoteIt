package com.example.noteit.ui.board.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.noteit.R
import com.example.noteit.data.model.BoardModel
import com.example.noteit.databinding.FragmentBoardBinding
import com.example.noteit.ui.board.adapter.BoardAdapter

class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(loadBoardData(), ::onStartBoard, ::onSkipBoard)
        binding.vpBoard.adapter = adapter
        val wormDotsIndicator = binding.dotsIndicator
        val viewPager = binding.vpBoard
        viewPager.adapter = adapter
        wormDotsIndicator.attachTo(viewPager)}

    private fun onSkipBoard() {
        binding.vpBoard.currentItem = loadBoardData().size
    }

    private fun onStartBoard() {
        findNavController().navigate(
            R.id.action_boardFragment_to_mainFragment,
            null,
            NavOptions.Builder()
                .setPopUpTo(R.id.boardFragment, true) // удаляет BoardFragment из стека
                .build()
        )

    }

    private fun loadBoardData(): ArrayList<BoardModel> {
        return arrayListOf(
            BoardModel(
                "Мысли",
                "Записывай всё, что приходит в голову: важные идеи, быстрые заметки, планы на будущее и даже вдохновение. Твои мысли больше не потеряются и всегда будут рядом, когда они нужны.",
//                R.drawable.writing
                "https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExenRvbTM4OWY3emV6djFmNmYxcHRjcHNiMWUxb2Qyb2w3emgyYmc5eiZlcD12MV9naWZzX3NlYXJjaCZjdD1n/29GGY6HStbm81GXc1h/giphy.gif"
            ),
            BoardModel(
                "Порядок",
                "Создавай списки дел, группируй заметки по категориям и используй удобный поиск. Поддерживай порядок без лишних усилий — всё организовано так, как удобно именно тебе.",
//                R.drawable.writing2
                "https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExOGFzaGZsbDZraWEzZXppNHZvNTNobWx4cG8xa2J0Y2s2dml5emxlaiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/XQiJigZpYQ9dKrrEbv/giphy.gif"
            ),
            BoardModel(
                "Удобство",
                "Твои записи будут с тобой в любое время и в любом месте. На учёбе, на работе или в дороге — открывай блокнот и находи нужную информацию за секунды. Всегда рядом, всегда доступно.",
//                R.drawable.writing3
                "https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExdmJrajB0ZWpsNmVnZDd3aGYxa3hxNHpjMDBqNDExNjFydXJtbTdzNCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/NtCw4NZGWJ3vvpgfvx/giphy.gif"
            )

        )
    }
}