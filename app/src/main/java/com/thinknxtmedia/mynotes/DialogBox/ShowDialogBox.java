package com.thinknxtmedia.mynotes.DialogBox;

import android.app.Activity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ShowDialogBox {
   public void show(Activity activity,int id){
       final  BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
       bottomSheetDialog.setContentView(id);
       bottomSheetDialog.show();
   }
}
