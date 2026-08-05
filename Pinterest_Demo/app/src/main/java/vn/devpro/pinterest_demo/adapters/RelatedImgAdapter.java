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

public class RelatedImgAdapter extends RecyclerView.Adapter<RelatedImgAdapter.ViewHolder> {
    public interface OnClickItemListener {
        void onItemClick(int image, int avatar, String name, boolean isFavorite, boolean isSaved);
    }
    List<Image_Info> relatedImgs;

    private RelatedImgAdapter.OnClickItemListener listener = null;

    public RelatedImgAdapter(List<Image_Info> relatedImgs) {
        this.relatedImgs = relatedImgs;
    }

    public void setListener(RelatedImgAdapter.OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.related_img_item, parent, false);
        return new RelatedImgAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image_Info relatedImg = relatedImgs.get(position);
        holder.relatedImg.setImageResource(relatedImg.getImage());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(
                        relatedImg.getImage(), relatedImg.getAvatar(), relatedImg.getName(),
                        relatedImg.isFavorite(), relatedImg.isSaved());
            }
        });
    }

    @Override
    public int getItemCount() {
        return relatedImgs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView relatedImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relatedImg = itemView.findViewById(R.id.relatedImg);
        }
    }
}
