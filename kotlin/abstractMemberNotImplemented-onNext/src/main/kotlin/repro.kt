import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class LoggingObserver<T>() : Observer<T>, Subscriber<T> {
	override fun onSubscribe(s: Subscription) = println("onSubscribe(s=$s)")
	override fun onSubscribe(d: Disposable) = println("onSubscribe(d=$d)")
	override fun onNext(value: T) = println("onNext($value)")
	override fun onError(e: Throwable) = println("onError(${e.message})")
	override fun onComplete() = println("onComplete()")
}
