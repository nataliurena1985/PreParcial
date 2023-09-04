package com.example.preparcial.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.preparcial.R
import com.example.preparcial.models.Company

class CompaniesAdapter(
    private val list: List<Company>,
    private val onItemClick: (Company) -> Unit
) :
    RecyclerView.Adapter<CompaniesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.company_item, parent, false)

       Log.d("COMPANY ADAPTER","onCreateViewHolder")
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val company = list[position]
        holder.bind(company)
        holder.setOnClickListener {
            onItemClick(company)
        }
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(company: Company) {
            val txtName: TextView = v.findViewById(R.id.txtName)
            txtName.text = company.name

            val imgLogo: ImageView = v.findViewById(R.id.imgLogo)
            Glide.with(imgLogo)
                .load(company.logo)
                .centerCrop()
                .into(imgLogo)
        }

        fun setOnClickListener(onClick: () -> Unit) {
            v.setOnClickListener {
                onClick()
            }
        }
    }
}