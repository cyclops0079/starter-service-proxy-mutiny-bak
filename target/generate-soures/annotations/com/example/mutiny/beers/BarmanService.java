package com.example.mutiny.beers;

import java.util.Map;
import java.util.stream.Collectors;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.util.function.Consumer;
import io.smallrye.mutiny.vertx.TypeArg;
import io.vertx.codegen.annotations.Fluent;
import io.smallrye.common.annotation.CheckReturnValue;
import com.example.beers.Beer;
import io.vertx.core.Future;

@io.smallrye.mutiny.vertx.MutinyGen(com.example.beers.BarmanService.class)
public class BarmanService {

  public static final io.smallrye.mutiny.vertx.TypeArg<BarmanService> __TYPE_ARG = new io.smallrye.mutiny.vertx.TypeArg<>(    obj -> new BarmanService((com.example.beers.BarmanService) obj),
    BarmanService::getDelegate
  );

  private final com.example.beers.BarmanService delegate;
  
  public BarmanService(com.example.beers.BarmanService delegate) {
    this.delegate = delegate;
  }

  public BarmanService(Object delegate) {
    this.delegate = (com.example.beers.BarmanService)delegate;
  }

  /**
   * Empty constructor used by CDI, do not use this constructor directly.
   **/
  BarmanService() {
    this.delegate = null;
  }

  public com.example.beers.BarmanService getDelegate() {
    return delegate;
  }

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BarmanService that = (BarmanService) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  @CheckReturnValue
  public io.smallrye.mutiny.Uni<com.example.beers.Beer> giveMeAStaticBeer(String customerName) { 
    return io.smallrye.mutiny.vertx.UniHelper.toUni(delegate.giveMeAStaticBeer(customerName));}

  public com.example.beers.Beer giveMeAStaticBeerAndAwait(String customerName) { 
    return giveMeAStaticBeer(customerName).await().indefinitely();
  }


  public void giveMeAStaticBeerAndForget(String customerName) { 
    giveMeAStaticBeer(customerName).subscribe().with(io.smallrye.mutiny.vertx.UniHelper.NOOP);
  }


  @CheckReturnValue
  public io.smallrye.mutiny.Uni<Integer> getMyBill(String customerName) { 
    return io.smallrye.mutiny.vertx.UniHelper.toUni(delegate.getMyBill(customerName));}

  public Integer getMyBillAndAwait(String customerName) { 
    return getMyBill(customerName).await().indefinitely();
  }


  public void getMyBillAndForget(String customerName) { 
    getMyBill(customerName).subscribe().with(io.smallrye.mutiny.vertx.UniHelper.NOOP);
  }


  @CheckReturnValue
  public io.smallrye.mutiny.Uni<Void> payMyBill(String customerName) { 
    return io.smallrye.mutiny.vertx.UniHelper.toUni(delegate.payMyBill(customerName));}

  public Void payMyBillAndAwait(String customerName) { 
    return payMyBill(customerName).await().indefinitely();
  }


  public void payMyBillAndForget(String customerName) { 
    payMyBill(customerName).subscribe().with(io.smallrye.mutiny.vertx.UniHelper.NOOP);
  }


  public static com.example.mutiny.beers.BarmanService createProxy(io.vertx.mutiny.core.Vertx vertx, String address) { 
    com.example.mutiny.beers.BarmanService ret = com.example.mutiny.beers.BarmanService.newInstance((com.example.beers.BarmanService)com.example.beers.BarmanService.createProxy(vertx.getDelegate(), address));
    return ret;
  }

  public static  BarmanService newInstance(com.example.beers.BarmanService arg) {
    return arg != null ? new BarmanService(arg) : null;
  }

}
