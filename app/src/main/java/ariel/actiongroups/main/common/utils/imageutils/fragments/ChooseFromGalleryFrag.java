package ariel.actiongroups.main.common.utils.imageutils.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.io.Serializable;

import ariel.actiongroups.main.common.users.sharedprefrences.SharedPrefManager;
import ariel.actiongroups.main.common.utils.imageutils.ImageUtils;

public class ChooseFromGalleryFrag extends Fragment implements Serializable {
    private final int RESULT_LOAD_IMAGE = 2;
    Intent data;


    public ChooseFromGalleryFrag() {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI); // Create intent to Open Image applications like Gallery, Google Photos
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);// Start the Intent
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.data = data;
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == getActivity().RESULT_OK && null != data) {
                String senderName = SharedPrefManager.getInstance(getContext()).getUserName();
                Uri selectedImageUri = data.getData();
                int[] imageSizes = ImageUtils.chooseImageSizes(getActivity(), 2, 2);
                ImageUtils.createBitmapFromImageSource(senderName, getActivity(), selectedImageUri, imageSizes[0], imageSizes[1]);
            } else {
                Toast.makeText(getActivity(), "You haven't picked an Image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }
}



