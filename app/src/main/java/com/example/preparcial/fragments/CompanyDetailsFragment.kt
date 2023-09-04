package com.example.preparcial.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.preparcial.R

class CompanyDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CompanyDetailsFragment()
    }

    private lateinit var viewModel: CompanyDetailsViewModel
    private val args: CompanyDetailsFragmentArgs by navArgs()
    private lateinit var v: View

    lateinit var txtName: TextView
    lateinit var txtEmployees: TextView
    lateinit var txtDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_company_details, container, false)

        txtName = v.findViewById(R.id.textCompanyName)
        txtEmployees = v.findViewById(R.id.textEmployedQtty)
        txtDescription = v.findViewById(R.id.textCompanyDescription)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtName.text = args.company.name
        txtEmployees.text = args.company.employeeQty.toString()
        txtDescription.text = args.company.description

        val imgLogo : ImageView = view.findViewById(R.id.imgLogo)
        Glide
            .with(imgLogo)
            .load(args.company.logo)
            .centerCrop()
            .into(imgLogo)
    }

}