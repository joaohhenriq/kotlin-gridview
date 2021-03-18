package com.joaohhenriq.kotlin_gridview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_widget.view.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    var itemList = ArrayList<ItemModel>()
    var adapterGridView: ItemWidgetAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadItems()
    }

    private fun loadItems() {
        itemList.add(ItemModel("Item 1", "Description 1", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 2", "Description 2", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 3", "Description 3", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 4", "Description 4", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 5", "Description 5", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 6", "Description 6", R.drawable.ic_launcher_foreground))
        itemList.add(ItemModel("Item 7", "Description 7", R.drawable.ic_launcher_foreground))

        adapterGridView = ItemWidgetAdapter(this, itemList)
        gridView.adapter = adapterGridView
    }

    class ItemWidgetAdapter: BaseAdapter {
        var itemsList = ArrayList<ItemModel>()
        var context: Context? = null

        constructor(context: Context, itemList: ArrayList<ItemModel>):super() {
            this.itemsList = itemList
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = inflater.inflate(R.layout.item_widget, null)

            itemView.imageView.setImageResource(itemsList[position].image)
            itemView.textView.text = itemsList[position].name

            itemView.setOnClickListener {
                val intent = Intent(context, ItemDetails::class.java)
                intent.putExtra("name", itemsList[position].name)
                intent.putExtra("des", itemsList[position].des)
                intent.putExtra("image" ,itemsList[position].image)
                context!!.startActivity(intent)
            }

            return itemView
        }

        override fun getItem(position: Int): Any {
            return itemsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return itemsList.size
        }

    }
}