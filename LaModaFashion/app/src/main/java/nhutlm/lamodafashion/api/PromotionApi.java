package nhutlm.lamodafashion.api;

import java.util.List;

import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.models.Promotions;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public interface PromotionApi {

    //Get list of promotions
    @GET("Promotion")
    Observable<Promotions> getPromotions(@Query("fields") List<String> fields, @Query("filterByFormula") String filter,
                                         @Query("maxRecords") Integer maxRecords, @Query("pageSize") Integer pageSize, @Query("sort") List<Object> sort,
                                         @Query("view") String view);
    //Retrive a Promotion record
    @GET("Promotion/{id}")
    Observable<Promotion> getPromotion(@Path("id") String id);

}
