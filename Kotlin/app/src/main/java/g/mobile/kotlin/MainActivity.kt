package g.mobile.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import g.mobile.kotlin.fragment.AFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val af = AFragment.newInstance()
        getFragment(af)
    }

    fun getFragment(fragment: Fragment){
        val fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.activity_base_content,fragment)
        fm.commit()
    }

//    fun changeFragment(f : Fragment,cleanStack: Boolean = false){
//        val ft = supportFragmentManager.beginTransaction()
//        if(cleanStack){
//            clearBackStack()
//        }
//
//        ft.setCustomAnimations(
//            R.anim.abc_fade_in,R.anim.abc_fade_out,R.anim.abc_popup_enter,R.anim.abc_popup_exit
//        )
//        ft.replace(R.id.activity_base_content,f)
//        ft.addToBackStack(null)
//        ft.commit()
//    }
//
//    fun clearBackStack(){
//        val mn = supportFragmentManager
//        if(mn.backStackEntryCount > 0){
//            val first = mn.getBackStackEntryAt(0)
//            mn.popBackStack(first.id,FragmentManager.POP_BACK_STACK_INCLUSIVE)
//        }
//    }
//
//    override fun onBackPressed() {
//        val fm = supportFragmentManager
//        if(fm.backStackEntryCount > 1){
//            fm.popBackStack()
//        }else{
//            finish()
//        }
//    }
}
