package listeners;

import java.util.ArrayList;

import model.Res_Photos;

/**
 * Created by jigsaw on 21/2/18.
 */

public interface Listener_PhotoSelected {

    void photoSelected(ArrayList<Res_Photos.List> arrayList,int position);

}
