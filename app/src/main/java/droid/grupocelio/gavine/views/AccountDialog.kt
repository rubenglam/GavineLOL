package droid.grupocelio.gavine.views

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AccountDialog : DialogFragment() {

    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments!!.getString("content")

        val style = DialogFragment.STYLE_NO_FRAME
        //val theme = R.style.DialogTheme
        setStyle(style, theme)
    }

    // Override the Fragment.onAttach() method to instantiate the
    // NoticeDialogListener
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)



    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_dialog, container, false)

        val btnCancel = view.findViewById<View>(R.id.buttonCancel) as Button
        val btnAccept = view.findViewById<View>(R.id.buttonAccept) as ImageButton

        val textViewContent = view.findViewById<View>(R.id.textViewContent) as TextView
        textViewContent.text = content

        //FontUtils.setTypeface(getActivity(), textViewQuestion, "fonts/mangal.ttf");
        //FontUtils.setTypeface(getActivity(), textViewAnswer, "fonts/mangal.ttf");
        btnCancel.setOnClickListener {
            Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnAccept.setOnClickListener {
            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return view
    }

    companion object {


        /**
         * Create a new instance of CustomDialogFragment, providing "num" as an
         * argument.
         */
        fun newInstance(content: String): AccountDialog {
            val f = AccountDialog()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("content", content)
            f.arguments = args

            return f
        }
    }

}