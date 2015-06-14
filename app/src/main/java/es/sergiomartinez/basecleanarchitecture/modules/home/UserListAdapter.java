package es.sergiomartinez.basecleanarchitecture.modules.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.modules.detail.UserDetailActivity;
import es.sergiomartinez.basecleanarchitecture.presentation.home.ListEventListener;
import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoader;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> implements
    ListEventListener {

  private final TypedValue mTypedValue = new TypedValue();
  private int mBackground;
  private List<PresentationUser> users;
  private ImageLoader imageLoader;
  private Gson gson;
  private Context context;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public String mBoundString;

    public final View mView;
    public final ImageView mImageView;
    public final TextView mTextView;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mImageView = (ImageView) view.findViewById(R.id.avatar);
      mTextView = (TextView) view.findViewById(android.R.id.text1);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mTextView.getText();
    }
  }

  public PresentationUser getValueAt(int position) {
    return users.get(position);
  }

  public UserListAdapter(Context context, List<PresentationUser> items, ImageLoader imageLoader,
      Gson gson) {
    context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
    mBackground = mTypedValue.resourceId;
    users = items;
    this.context = context;
    this.imageLoader = imageLoader;
    this.gson = gson;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false);
    view.setBackgroundResource(mBackground);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    holder.mBoundString = users.get(position).name.first;
    holder.mTextView.setText(users.get(position).name.first);

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(UserDetailActivity.EXTRA_NAME,
            gson.toJson(users.get(position), PresentationUser.class));

        context.startActivity(intent);
      }
    });

    imageLoader.loadCircleImage(users.get(position).picture.getThumbnail(), holder.mImageView, null);
  }

  @Override
  public void addUsers(List<PresentationUser> users){
    this.users.addAll(users);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return users.size();
  }
}
