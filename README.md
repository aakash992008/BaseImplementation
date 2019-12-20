**BASE IMPLEMENTATION FOR MVVM**

Base Activity here extends AppCompactActivity
Base Fragment here extends Fragment

**BASE ACTIVITY**

To extend this base activity you have to pass **`DataBinding`** class
eg-> class ActivityA extends BaseActivity<ActivityDataBinding>{}


Since this Base Activity is abstract so we have to override some methods too

    abstract fun getLayout():Int (Return the layout which need to be displayed)
    abstract fun onBaseResume() (Same as OnResume())
    abstract fun onBasePause() (Same as onPause())
    abstract fun initialisationBlock(savedInstanceState: Bundle?) (Same as OnCreate())

***This Base Activity also supports Navigation Arch Component***

So there is no need for initialisation just use the variable navController if you are using arch Component.
Binding also get initialised automatically so you have to use mBinding variable

**Toast Generation made easy**
Just call the method generateToast method passing either of the two

fun generateToast(message:Int,length:Int=Toast.LENGTH_SHORT)
fun generateToast(message:String,length:Int=Toast.LENGTH_SHORT)


**Showing Progress bar made easy**
Just call the method showProgressBar() in the extending class

Progress bar can be customised just call the method setProgressBarView(view: View) passing the view to be displayed before calling showProgressBar()

Now control the progress bar using two methods

fun showProgressBar()
fun hideProgressBar()



