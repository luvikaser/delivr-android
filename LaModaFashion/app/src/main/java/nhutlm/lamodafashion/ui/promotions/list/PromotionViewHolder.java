package nhutlm.lamodafashion.ui.promotions.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Promotion;
import rx.subjects.PublishSubject;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */

public class PromotionViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.item_promotion_image)
    ImageView imagePromotion;
    @BindView(R.id.item_promotion_name)
    TextView namePromotion;
    @BindView(R.id.item_promotion_price)
    TextView pricePromotion;
    @BindView(R.id.item_promotion_favorite)
    ImageView favoritePromotion;

    public PromotionViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition()));
    }

    void bind(Promotion promotion) {
          Glide.with(view.getContext()).load(promotion.getFields().getPicture().get(0).getThumbnails().getLarge().getUrl()).into(imagePromotion);
          namePromotion.setText(TextUtils.isEmpty(promotion.getFields().getName()) ? "missing title" : promotion.getFields().getName());
          pricePromotion.setText(TextUtils.isEmpty(promotion.getFields().getPrice()) ? "missing year" : promotion.getFields().getPrice());
    }

}