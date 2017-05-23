package nhutlm.lamodafashion.api;

import java.util.List;

import nhutlm.lamodafashion.models.Promotions;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public interface PromotionApi {

    @GET("Promotion")
    Observable<Promotions> getPromotions(@Query("fields") List<String> fields, @Query("filterByFormula") String filter,
                                         @Query("maxRecords") Integer maxRecords, @Query("pageSize") Integer pageSize, @Query("sort") List<Object> sort,
                                         @Query("view") String view);


}
