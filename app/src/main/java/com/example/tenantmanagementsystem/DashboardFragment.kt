package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
// Generated from fragment_dashboard.xml (View Binding)
import com.example.tenantmanagementsystem.databinding.FragmentDashboardBinding
import kotlin.text.format
import androidx.navigation.fragment.findNavController
import android.util.Log



class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // 1. The Fragment OBJECT is created (no view yet)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onCreate")
    }

    // 2. Build the VIEW from fragment_dashboard.xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onCreateView")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    // 3. The view exists: fill in the metrics and set click listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onViewCreated")
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()
        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)
        binding.addTenantButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            findNavController().navigate(action)
        }
        binding.viewTenantsButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            findNavController().navigate(action)
        }
    }

    // 4. Visible
    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onStart")
    }

    // 5. In front, user can interact
    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onResume")
    }

    // 6. Leaving the front
    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onPause")
    }

    // 7. No longer visible
    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onStop")
    }

    // 8. The VIEW is destroyed. Clear the binding so the old view can be freed
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onDestroyView")
        _binding = null
    }

    // 9. The Fragment OBJECT is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", " DashboardFragment: onDestroy")
    }
}

/*class DashboardFragment : Fragment() {
    // _binding can be null (no view yet, or view destroyed)
    private var _binding: FragmentDashboardBinding? = null
    // binding is a shortcut we only use while the view exists
    private val binding get() = _binding!!
    // Build this screen's view from fragment_dashboard.xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root // hand the view to the NavHost to display
    }
    // The view now exists: fill in the metrics
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// Read from the shared list of tenants
        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()
        // tenantCountTextView ← android:id="@+id/tenantCountTextView"
        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
// totalRentTextView ← android:id="@+id/totalRentTextView"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)
        binding.addTenantButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            findNavController().navigate(action)
        }
        binding.viewTenantsButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            findNavController().navigate(action)
        }
    }
    // The view is destroyed: let go of it
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/