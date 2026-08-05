package vn.devpro.pinterest_demo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.devpro.pinterest_demo.R;
import vn.devpro.pinterest_demo.models.Image_Info;

public class SavedImgAdapter extends RecyclerView.Adapter<SavedImgAdapter.ViewHolder> {
    public interface OnClickItemListener {
        void onItemClick(int image, int avatar, String name, boolean isFavorite, boolean isSaved);
    }
    List<Image_Info> savedImgs;

    private OnClickItemListener listener = null;
    public SavedImgAdapter(List<Image_Info> savedImgs) {
        this.savedImgs = savedImgs;
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_img_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image_Info savedImg = savedImgs.get(position);
        holder.savedImg.setImageResource(savedImg.getImage());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(
                        savedImg.getImage(),
                        savedImg.getAvatar(),
                        savedImg.getName(),
                        savedImg.isFavorite(),
                        savedImg.isSaved());
            }
        });
    }

    @Override
    public int getItemCount() {
        return savedImgs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView savedImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            savedImg = itemView.findViewById(R.id.savedImg);
        }
    }
}
