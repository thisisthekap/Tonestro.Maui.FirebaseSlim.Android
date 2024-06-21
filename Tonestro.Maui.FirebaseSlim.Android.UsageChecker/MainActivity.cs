using Com.Tonestro.Firebaseslim;

namespace Tonestro.Maui.FirebaseSlim.Android.UsageChecker;

[Activity(Label = "@string/app_name", MainLauncher = true)]
public class MainActivity : Activity
{
    protected override void OnCreate(Bundle? savedInstanceState)
    {
        base.OnCreate(savedInstanceState);

        var analyticsManager = AnalyticsManagerFactory.CreateInstance(this);
        
        // Set our view from the "main" layout resource
        SetContentView(Resource.Layout.activity_main);
    }
}