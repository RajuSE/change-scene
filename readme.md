

# change-scene <br>
helps easily switch between different layouts without writing much code of View visibility. 


## Setup
Add __change-scene__ to your dependencies block:
```groovy
    compile 'com.github.rajuse.changescene:change-scene:1.0.0'
```


## Usage
#### ChangeSceneLayout
Add a `ChangeSceneLayout` to your layout just like any other view. Check benefits mentioned below. 

```xml
<dev.raju.lib.changescene.ChangeSceneLayout
        android:id="@+id/rootView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        <!--Your Default-Scene-->
        
</dev.raju.lib.changescene.ChangeSceneLayout>
```

For example:<br>

```xml
    <dev.raju.lib.changescene.ChangeSceneLayout
        android:id="@+id/rootView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:textColor="@android:color/white" />
    </dev.raju.lib.changescene.ChangeSceneLayout>
```

Note: `ChangeSceneLayout` is custom RelativeLayout. Hence Its easy to design your `Default-Scene`.

### methods:
- Change to your custom layout (`custom-scene`)<br>
    `#changeScene(R.layout.custom_scene);`
    
- Change to `progressbar`<br>
  `#showProgressScene(String progMessage)`
  
- Change to `default-scene`(i.e. childs of `ChangeSceneLayout`)<br>
    `#showContentScene();`
  
  
## Benefits

- Separates different states with different layouts.
- You can provide custom layout to be switched to.
- Progress-scene support for showing progress bar.
- Boilerplate code related with view visibility/invisibility is gone.



## Contributing
As always any enhancements, [PRs](https://github.com/RajuSE/change-scene/pulls) and [bugs](https://github.com/RajuSE/change-scene/issues) report will be highly appreciated. :-)
