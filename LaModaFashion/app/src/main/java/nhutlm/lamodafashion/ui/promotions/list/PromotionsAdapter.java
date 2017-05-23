package nhutlm.lamodafashion.ui.promotions.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Promotion;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Promotion> promotions = new ArrayList<>();


    public void swapAdapter(ArrayList<Promotion> promotions)
    {
        this.promotions.clear();
        this.promotions.addAll(promotions);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion, parent, false);
        return new PromotionViewHolder(view ,itemClicks);
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {

        Promotion promotion = promotions.get(position);
        holder.bind(promotion);

    }

    @Override
    public int getItemCount() {
        if (promotions != null && promotions.size() > 0) {
            return promotions.size();
        } else {
            return 0;
        }
    }
}