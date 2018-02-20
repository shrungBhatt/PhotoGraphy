package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.projects.shrungbhatt.photography.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import model.BaseModel;

/**
 * Created by jigsaw on 18/2/18.
 */

public class Fragment_Profile extends BaseFragment implements TabLayout.OnTabSelectedListener {


    @BindView(R.id.img_profile)
    CircleImageView imgProfile;
    @BindView(R.id.profile_username)
    TextView profileUsername;
    @BindView(R.id.profile_tablayout)
    TabLayout profileTablayout;
    @BindView(R.id.profile_fragment_container)
    FrameLayout profileFragmentContainer;
    Unbinder unbinder;
    FragmentManager mFragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, v);

        try {
            mFragmentManager = getActivity().getSupportFragmentManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUpTabLayout();


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setUpTabLayout() {
        profileTablayout.addTab(profileTablayout.newTab().setText("Tagged"));
        profileTablayout.addTab(profileTablayout.newTab().setText("Saved"));
        profileTablayout.setOnTabSelectedListener(this);

        if (mFragmentManager != null) {
            mFragmentManager.beginTransaction().replace(R.id.profile_fragment_container,
                    new Fragment_Tagged()).commit();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        int fragmentContainer = R.id.profile_fragment_container;

        switch (tab.getPosition()) {

            case 0:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Tagged()).commit();
                break;

            case 1:
                mFragmentManager.beginTransaction().replace(fragmentContainer,
                        new Fragment_Saved()).commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void handleSuccessData(BaseModel resModel) {

    }

    @Override
    public void handleZeroData(BaseModel reqModel) {

    }
}
