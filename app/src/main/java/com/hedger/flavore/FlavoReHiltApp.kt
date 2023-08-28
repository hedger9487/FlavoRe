package com.hedger.flavore

import android.app.Application
import dagger.hilt.android.HiltAndroidApp



// similar to App container make the dependency to app level
@HiltAndroidApp
class FlavoReHiltApp : Application() {}
