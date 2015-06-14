package es.sergiomartinez.basecleanarchitecture.base;

import butterknife.ButterKnife;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class BaseUIActivity extends BaseInjectionActivity {

  @Override public void setContentView(int layoutResID) {
      super.setContentView(layoutResID);
      ButterKnife.inject(this);
  }


}
