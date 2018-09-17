package com.bernst.d.federico.writesbestfriend.views


import android.content.Intent
import com.bernst.d.federico.writesbestfriend.views.activities.BasicActivity
import com.bernst.d.federico.writesbestfriend.views.activities.FormActivity
import com.bernst.d.federico.writesbestfriend.views.activities.HomeActivity
import com.bernst.d.federico.writesbestfriend.views.activities.ListActivity
import dagger.Module

@Module
class Navigator {
    //Activities
    fun goToNewCharacter(from: BasicActivity<*>, characterID: Long?) {
        val intent = Intent(from, FormActivity::class.java)
        from.startActivity(FormActivity.getIntent(intent, characterID))
    }

    fun goToHistorias(from: HomeActivity) {
        from.startActivity(ListActivity.getIntent(from))
    }

    fun goToPersonajes(from: HomeActivity) {
        from.startActivity(ListActivity.getIntent(from))
    }

    fun goToEventos(from: HomeActivity) {
        from.startActivity(ListActivity.getIntent(from))
    }

    fun goToArte(from: HomeActivity) {
        from.startActivity(ListActivity.getIntent(from))
    }

    /*
        public void showClient(MobilityActivity from, Long id_pdv, Long dia) {
            Intent intent = new Intent(from.getApplicationContext(), Vista360Activity.class);
            intent = Vista360Activity.putParams(intent,id_pdv, dia);
            from.startActivity(intent);
        }
        public void backToClient(MobilityActivity from, Long id_pdv, Long dia) {
            Intent intent = new Intent(from.getApplicationContext(), Vista360Activity.class);
            intent = Vista360Activity.putParams(intent,id_pdv, dia);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            from.startActivity(intent);
        }

        public void showNewLocation(MobilityActivity from, Long pdv_id, Long dia_id) {
            Intent intent = new Intent(from.getApplicationContext(), CoordenadasActivity.class);
            intent = CoordenadasActivity.putParams(intent,pdv_id,dia_id);
            from.startActivity(intent);
        }

        public void showMotivoNoVenta(MobilityActivity from, Long pdvId, Long dia_ruta, Long motNoVenta) {
            Intent intent = new Intent(from.getApplicationContext(), MotivoNoVentaActivity.class);
            intent = MotivoNoVentaActivity.putParams(intent,pdvId,dia_ruta, motNoVenta);
            from.startActivity(intent);
        }
        public void showPrograms(MobilityActivity from, int user, Long pdv) {
            Intent intent = new Intent(from.getApplicationContext(), ListProgramsActivity.class);
            intent = ListProgramsActivity.putParams(intent,user, pdv);
            from.startActivity(intent);
        }
        public void showActivs(MobilityActivity from, String paramExample) {
            Intent intent = new Intent(from.getApplicationContext(), ActivesActivity.class);
            intent = ActivesActivity.putParams(intent, paramExample);
            from.startActivity(intent);
        }
        public void showCobertura(MobilityActivity from,Long pdv) {
            Intent intent = new Intent(from.getApplicationContext(), CoberturaActivity.class);
            intent = CoberturaActivity.putParams(intent,pdv);
            from.startActivity(intent);
        }
        public void showNegociations(MobilityActivity from, int user, Long pdv) {
            Intent intent = new Intent(from.getApplicationContext(), ListNegociationsActivity.class);
            intent = ListNegociationsActivity.putParams(intent,user, pdv);
            from.startActivity(intent);
        }
        public void showLastOrder(MobilityActivity from, Long pdv, Long dia) {
            Intent intent = new Intent(from.getApplicationContext(), PropuestaActivity.class);
            intent = PropuestaActivity.putParams(intent,pdv, dia);
            from.startActivity(intent);
        }
        public void showNewOrder(MobilityActivity from, Long pdv, Long dia) {
            Intent intent = new Intent(from.getApplicationContext(), NuevoPedidoActivity.class);
            intent = NuevoPedidoActivity.putParams(intent,pdv, dia);
            from.startActivity(intent);
        }

        public void showRecommendedOrder(MobilityActivity from, Long pdv, Long dia, InfoProducto[] productos) {
            Intent intent = new Intent(from.getApplicationContext(), NuevoPedidoActivity.class);
            intent = NuevoPedidoActivity.putParams(intent,pdv, dia,productos);
            from.startActivity(intent);
        }

        public void showConfirmOrder(MobilityActivity from, String cod_pedido, Long diaId) {
            Intent intent = new Intent(from.getApplicationContext(), ConfirmacionActivity.class);
            intent = ConfirmacionActivity.putParams(intent, cod_pedido, diaId);
            from.startActivity(intent);
        }
        public void showRouteProgress(MobilityActivity from) {
            Intent intent = new Intent(from.getApplicationContext(), ProgresoActivity.class);
            intent = ProgresoActivity.putParams(intent);
            from.startActivity(intent);
        }
        public void showRouteFinish(MobilityActivity from) {
            Intent intent = new Intent(from.getApplicationContext(), CierreRutaActivity.class);
            intent = CierreRutaActivity.putParams(intent);
            from.startActivity(intent);
        }
        public void showSyncActivity(MobilityActivity from,Boolean rutaCerrada) {
            Intent intent = new Intent(from.getApplicationContext(), SyncActivity.class);
            intent = SyncActivity.putParams(intent,rutaCerrada);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            from.startActivity(intent);
        }
    */
    //Fragments
//    fun openPrimerFragment(from: HomeActivity) {
//        openFragment(from, PrimerFragment.newInstance(), from.getResources().getString(R.string.app_name), false)
//
//    }

    /*    public void openLoginFragment(LoginActivity from) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, LoginFragment.newInstance(), from.getResources().getString(R.string.app_name), false);
    }
    public void openExpandViewFragment(MobilityActivity from, Long pdvId, Long dia_id) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, Vista360Fragment.newInstance(pdvId,dia_id), from.getResources().getString(R.string.app_name), false);
    }
    public void openNewLocationFragment(MobilityActivity from, Long pdv_id, Long dia_id) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, CoordenadasFragment.newInstance(pdv_id,dia_id), from.getResources().getString(R.string.app_name), false);
    }
    public void openActivesFragment(MobilityActivity from, String param) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, ActivesFragment.newInstance(param), from.getResources().getString(R.string.app_name), false);
    }
    public CoberturaFragment openCoberturaFragment(MobilityActivity from,Long pdv_id) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return (CoberturaFragment) openFragment(from, CoberturaFragment.newInstance(pdv_id), from.getResources().getString(R.string.app_name), false);
    }
    public void openListOptionsFragment(MobilityActivity from, Long pdv_id, Long ruta_dia) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, MotivoNoVentaFragment.newInstance(pdv_id,ruta_dia), from.getResources().getString(R.string.app_name), false);
    }
    public void openLastOrderFragment(MobilityActivity from, Long pdv, Long dia_id) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, PropuestaFragment.newInstance(pdv, dia_id), from.getResources().getString(R.string.app_name), false);
    }
    public Fragment openNewOrderFragment(MobilityActivity from, Long pdv_id, Long dia_id, InfoProducto[] productos) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return openFragment(from, NuevoPedidoFragment.newInstance(pdv_id, dia_id,productos), from.getResources().getString(R.string.app_name), false);
    }
    public Fragment openAdvancedSearchFragment(MobilityActivity from, String param) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return openFragment(from, BusquedaFragment.newInstance(param), from.getResources().getString(R.string.app_name), false);
    }
    public ConfirmacionFragment openConfirmOrder(MobilityActivity from, String cod_pedido, Long diaId) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return (ConfirmacionFragment) openFragment(from, ConfirmacionFragment.newInstance(cod_pedido, diaId), from.getResources().getString(R.string.app_name), false);
    }
    public void openRouteProgress(MobilityActivity from) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, ProgresoFragmentCitric.newInstance(), from.getResources().getString(R.string.app_name), false);
    }
    public void openSyncFragment(MobilityActivity from,Boolean rutaCerrada) {
        //from.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openFragment(from, SyncFragment.newInstance(rutaCerrada), from.getResources().getString(R.string.app_name), false);
    }

    //PopUp
    public void showPopUpConfirmation(MobilityActivity from, MobilityFragment to,
                                      String popUpName, int popUpRequest,
                                      String title, String desc, String id_generico) {
        if(from.getSupportFragmentManager()
                .findFragmentByTag(popUpName) == null) {

            Bundle bundle = new Bundle();
            bundle.putString(PopUpConfirmacionFragment.POPUP_TITLE, title);
            bundle.putString(PopUpConfirmacionFragment.POPUP_DESC, desc);
            bundle.putString(PopUpConfirmacionFragment.POPUP_EXTRA, id_generico);
            bundle.putBoolean(PopUpConfirmacionFragment.POPUP_EXIT, false);
            PopUpConfirmacionFragment fragment = new PopUpConfirmacionFragment();
            fragment.setArguments(bundle);
            fragment.setTargetFragment(to,popUpRequest);
            from.getSupportFragmentManager()
                    .beginTransaction().add(fragment,popUpName)
                    .show(fragment).commit();
        }
    }

    public void showPopUpNotification(MobilityActivity from, MobilityFragment to,
                                      String popUpName, int popUpRequest,
                                      String title, String desc, String time, Boolean color_red) {
        if(from.getSupportFragmentManager()
                .findFragmentByTag(popUpName) == null) {

            Bundle bundle = new Bundle();
            bundle.putString(PopUpInfoActivoFragment.POPUP_TITLE,title);
            bundle.putString(PopUpInfoActivoFragment.POPUP_DESC,desc);
            bundle.putString(PopUpInfoActivoFragment.POPUP_TIME,time);
            bundle.putBoolean(PopUpInfoActivoFragment.POPUP_TIME,color_red);

            PopUpInfoActivoFragment fragment = new PopUpInfoActivoFragment();
            fragment.setArguments(bundle);
            fragment.setTargetFragment(to,popUpRequest);
            from.getSupportFragmentManager()
                    .beginTransaction().add(fragment,popUpName)
                    .show(fragment).commit();
        }
    }

    public void showPopUpList(MobilityActivity from, MobilityFragment to,
                              String popUpName, Integer popUpRequest,
                              Integer title_Resource, Integer array_Resource,
                              String idGenerico, Integer presenterID) {
        if(from.getSupportFragmentManager().findFragmentByTag(popUpName) == null) {

            Bundle bundle = new Bundle();
            if (array_Resource != null)
                bundle.putInt(PopUpFragment.POPUP_VALUES, array_Resource);

            bundle.putInt(PopUpFragment.POPUP_TITULO, title_Resource);
            bundle.putString(PopUpFragment.POPUP_IDGENERICO, idGenerico);
            bundle.putInt(PopUpFragment.POPUP_PRESENTER, presenterID);

            PopUpFragment fragment = new PopUpFragment();
            fragment.setArguments(bundle);
            fragment.setTargetFragment(to,popUpRequest);
            from.getSupportFragmentManager()
                    .beginTransaction().add(fragment,popUpName)
                    .show(fragment).commit();
        }
    }
*/
//    private fun openFragment(from: BasicActivity, fragment: Fragment, name: String, addToBackStack: Boolean): Fragment {
//        val transaction = from.getSupportFragmentManager().beginTransaction()
//        transaction.add(R.id.content_frame, fragment, name)
//        if (addToBackStack)
//            transaction.addToBackStack(name)
//        from.setTitle(name)
//        transaction.commit()
//        from.invalidateOptionsMenu()
//
//        return fragment
//    }

}