package uz.datatalim.networking.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.datatalim.networking.Model.BreedsItem
import uz.datatalim.networking.R

class BreedAdapter : RecyclerView.Adapter<ChatViewHolder>() {
    var itemClick: ((Int) -> Unit)? = null
    val list: ArrayList<BreedsItem> =ArrayList()

    fun submitList(list: ArrayList<BreedsItem>){

        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_breed, parent, false)
        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val user = list[position]
        holder.tvName.text = user.name
        Glide.with(holder.ivProfile).load(user.image?.url).into(holder.ivProfile)
        holder.llItem.setOnClickListener {
            itemClick?.invoke(position)
        }
    }
}


class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
    val llItem = view.findViewById<LinearLayout>(R.id.llItem)
    val tvName = view.findViewById<TextView>(R.id.tv_fullName)


}
