package com.bernst.d.federico.writesbestfriend.views.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.core.WritersbfApplication
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.viewmodel.CommonViewModel
import com.bernst.d.federico.writesbestfriend.views.Navigator
import com.google.android.gms.ads.*
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BasicActivity<T : CommonViewModel>(open val viewModelClazz: Class<T>) : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    protected lateinit var viewModel: T

    private var ads_KEY = resources.getString(R.string.ADS_KEY)
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private var client: GoogleApiClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        // Setup handler for uncaught exceptions.
        iniciarViewModel(this.component)
        setContentView(mainView)
        iniciarObservers()
        iniciarListeners()
        iniciarMenuDrawer()
        iniciarADs()
    }

    private fun iniciarViewModel(component: WritersbfComponents) {
        viewModel = ViewModelProviders.of(this).get(viewModelClazz)
        viewModel.init(component)
    }

    protected abstract fun iniciarObservers()

    protected abstract fun iniciarListeners()

    abstract val tituloId: Int

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = resources.getString(tituloId)
    }

    protected fun setBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun iniciarMenuDrawer() {
//        setSupportActionBar(toolbar)
//        menuPresenter.initialize(this, MenuPresenter.Params())
//
//        val headerResult = MenuBuilder()
//                .withPresenter(menuPresenter)
//                .withActivity(this)
//                .withSelectionListEnabled(false)
//                .withDividerBelowHeader(false)
//                .build()
//
//        menuDrawer = DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withAccountHeader(headerResult)
//                .withSelectedItem(-1)
//                .addDrawerItems(
//                        MenuDividerDrawerItem(),
//                        PrimaryDrawerItem().withName(nuevo_char_title).withIdentifier(1),
//                        MenuDividerDrawerItem(),
//                        PrimaryDrawerItem().withName(listado_chars_title).withIdentifier(2),
//                        MenuDividerDrawerItem(),
//                        PrimaryDrawerItem().withName(historias_title).withIdentifier(3),
//                        MenuDividerDrawerItem(),
//                        PrimaryDrawerItem().withName(cerrarSesion).withIdentifier(4)
//                )
//                /*.withStickyFooterDivider(true)
//                    .addStickyDrawerItems(
//                            new CustomDividerDrawerItem(),
//                            new PrimaryDrawerItem().withName("Cerrar sesion").withIcon(GoogleMaterial.Icon.gmd_close_circle).withIdentifier(6)
//                    )*/
//                .withOnDrawerNavigationListener {
//                    onBackPressed()
//                    true
//                }
//                .withOnDrawerItemClickListener { view, position, drawerItem ->
//                    when (drawerItem.identifier.toInt()) {
//                        1 -> {
//                        }
//                        2 -> {
//                        }
//                        3 -> {
//                        }
//
//                        4 -> {
//                        }
//                        else -> {
//                        }
//                    }/*                                if (getActivity().getSupportFragmentManager().findFragmentByTag("POPUP") == null) {
//                                    PopUpConfirmacionFragment popUp = new PopUpConfirmacionFragment();
//
//                                    OnDialogResponseListener listener = new OnDialogResponseListener() {
//
//                                        private PopUpConfirmacionFragment popUp;
//
//                                        public void setPopUp(PopUpConfirmacionFragment popUp) {
//                                            this.popUp = popUp;
//                                        }
//
//                                        @Override
//                                        public void onDialogResponse(int responseCode) {
//                                            if (responseCode == Activity.RESULT_OK) {
//                                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                                intent.putExtra("EXIT", true);
//                                                startActivity(intent);
//                                            } else if (responseCode == Activity.RESULT_CANCELED) {
//                                                popUp.dismiss();
//                                            }
//                                        }
//
//                                        @Override
//                                        public int describeContents() {
//                                            return 0;
//                                        }
//
//                                        @Override
//                                        public void writeToParcel(Parcel parcel, int i) {
//                                        }
//                                    };
//                                    listener.setPopUp(popUp);
//
//                                    Bundle bundle = new Bundle();
//                                    bundle.putString(PopUpConfirmacionFragment.POPUP_TITLE, mobility_popup_titulo);
//                                    bundle.putString(PopUpConfirmacionFragment.POPUP_DESC, mobility_popup_explicacion);
//                                    bundle.putParcelable(PopUpConfirmacionFragment.LISTENER, listener);
//                                    bundle.putBoolean(PopUpConfirmacionFragment.POPUP_EXIT, true);
//                                    popUp.setArguments(bundle);
//                                    getActivity().getSupportFragmentManager()
//                                            .beginTransaction().add(popUp, "POPUP")
//                                            .show(popUp).commit();
//                                }
//  */
//                    false
//                }
//                .build()
    }

    /*    public void showPopUpExit(){
        if (getActivity().getSupportFragmentManager().findFragmentByTag("POPUP") == null) {
            PopUpConfirmacionFragment popUp = new PopUpConfirmacionFragment();

            OnDialogResponseListener listener = new OnDialogResponseListener() {

                private PopUpConfirmacionFragment popUp;

                public void setPopUp(PopUpConfirmacionFragment popUp) {
                    this.popUp = popUp;
                }

                @Override
                public void onDialogResponse(int responseCode) {
                    if (responseCode == Activity.RESULT_OK) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    } else if (responseCode == Activity.RESULT_CANCELED) {
                        popUp.dismiss();
                    }
                }
                @Override
                public int describeContents() { return 0; }

                @Override
                public void writeToParcel(Parcel parcel, int i) { }
            };
            listener.setPopUp(popUp);

            Bundle bundle = new Bundle();
            bundle.putString(PopUpConfirmacionFragment.POPUP_TITLE, mobility_popup_titulo);
            bundle.putString(PopUpConfirmacionFragment.POPUP_DESC, mobility_popup_explicacion);
            bundle.putParcelable(PopUpConfirmacionFragment.LISTENER, listener);
            bundle.putBoolean(PopUpConfirmacionFragment.POPUP_EXIT, true);
            popUp.setArguments(bundle);
            getActivity().getSupportFragmentManager()
                    .beginTransaction().add(popUp, "POPUP")
                    .show(popUp).commit();
        }
    }
*/

    private val component: WritersbfComponents
        get() = (application as WritersbfApplication).component

    protected abstract val mainView: Int

    protected abstract val adView: AdView?

    abstract fun injectDependencies(components: WritersbfComponents)

    private fun iniciarADs() {
        MobileAds.initialize(this, ads_KEY)
        val adRequest = AdRequest.Builder().build()

        adView?.visibility = View.GONE
        adView?.adSize = AdSize.SMART_BANNER
        adView?.adUnitId = ads_KEY
        adView?.adListener = object : AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                adView?.visibility = View.VISIBLE
            }
        }
        adView?.loadAd(adRequest)
    }
}
