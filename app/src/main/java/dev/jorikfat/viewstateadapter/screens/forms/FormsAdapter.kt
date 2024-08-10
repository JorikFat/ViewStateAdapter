package dev.jorikfat.viewstateadapter.screens.forms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jorikfat.viewstateadapter.databinding.ItemFormBinding
import dev.jorikfat.viewstateadapter.models.form.Form

class FormsAdapter(
    private val forms :List<Form>,
    private val callback :(Form)->Unit
) :RecyclerView.Adapter<FormsAdapter.FormViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder =
        FormViewHolder(
            ItemFormBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                callback.invoke(forms[adapterPosition])
            }
        }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) =
        holder.bind(forms[position])

    override fun getItemCount(): Int = forms.size

    class FormViewHolder(
        private val layout :ItemFormBinding
    ) :RecyclerView.ViewHolder(layout.root) {

        fun bind(form :Form){
            layout.title.text = form.title
            layout.count.text = "Количество полей: ${form.fields.size}"
        }
    }
}