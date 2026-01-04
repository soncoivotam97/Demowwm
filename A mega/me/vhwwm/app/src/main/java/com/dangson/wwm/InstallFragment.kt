package com.dangson.wwm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dangson.wwm.databinding.FragmentInstallBinding

class InstallFragment : Fragment() {

    private var _binding: FragmentInstallBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnInstall.setOnClickListener {
            (activity as MainActivity).installVietHoa(
                onLog = { msg -> binding.logText.append(msg) },
                onFinish = { binding.btnInstall.text = "CÀI LẠI VIỆT HÓA" }
            )
        }

        binding.btnUninstall.setOnClickListener {
            (activity as MainActivity).uninstallVietHoa(
                onLog = { msg -> binding.logText.append(msg) },
                onFinish = { binding.btnInstall.text = "CÀI ĐẶT VIỆT HÓA" }
            )
        }

        // Xóa log cũ khi mở lại fragment
        binding.logText.text = "Sẵn sàng...\n\n"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}