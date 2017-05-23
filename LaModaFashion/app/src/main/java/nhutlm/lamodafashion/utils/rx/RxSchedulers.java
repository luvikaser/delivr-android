package nhutlm.lamodafashion.utils.rx;

import rx.Scheduler;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();

}
