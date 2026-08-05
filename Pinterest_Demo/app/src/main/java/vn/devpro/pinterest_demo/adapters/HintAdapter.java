package vn.devpro.pinterest_demo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.devpro.pinterest_demo.R;
import vn.devpro.pinterest_demo.models.Hint;

public class HintAdapter extends RecyclerView.Adapter<HintAdapter.ViewHolder> {

    private List<Hint> hints;
    private int selectedHint = 2;

    public HintAdapter(List<Hint> hints) {
        this.hints = hints;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hint_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hint hint = hints.get(position);
        holder.hint.setText(hint.getHint());

        if (position == selectedHint) {
            holder.underline.setVisibility(View.VISIBLE);
        } else {
            holder.underline.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(v -> {
            int prvSelectedHint = selectedHint;
            selectedHint = holder.getBindingAdapterPosition();

            if (selectedHint == RecyclerView.NO_POSITION) return;

            notifyItemChanged(prvSelectedHint);
            notifyItemChanged(selectedHint);
        });
    }

    @Override
    public int getItemCount() {
        return hints.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView hint;
        View underline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hint = itemView.findViewById(R.id.hint);
            underline = itemView.findViewById(R.id.underline);
        }
    }
}
