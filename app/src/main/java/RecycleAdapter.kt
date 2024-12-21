package com.jynette.swalafoodapp

import android.content.Context
    import android.content.Intent
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import android.widget.Toast
    import androidx.recyclerview.widget.RecyclerView
    // This is an Adapter that Creates The data to Put in Our Recycler View.
    class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
        // Array of Food titles
        private val titles = arrayOf("Burger",
            "Fish Fillet", "Breakfast", "Snacks",
            "Chinese", "Spaghetti", "Rice",
            "Freshy")
        // Array of Food Details
        private val details = arrayOf("Item one details This is Nice Food", "Item two details This is Nice Food",
            "Item three details This is Nice Food", "Item four details This is Nice Food",
            "Item file details This is Nice Food", "Item six details This is Nice Food",
            "Item seven details  This is Nice Food", "Item eight details  This is Nice Food")
        // Array of Food costs
        private val cost = arrayOf("1,300KES", "1,100KES", "200KES", "1200KES",
            "800KES", "100KES", "300KES", "250KES")

        // Array of Food images

        private val images = intArrayOf(R.drawable.food1,
            R.drawable.food2, R.drawable.food3,
            R.drawable.food4, R.drawable.food5,
            R.drawable.food6, R.drawable.food7,
            R.drawable.food8)



        // Access the Single item XML Layout
        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
            val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.singleitem, viewGroup, false)
            return ViewHolder(v)
        }

        //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var itemImage: ImageView
            var itemTitle: TextView
            var itemDetail: TextView
            var itemCost: TextView

            init {
                itemImage = itemView.findViewById(R.id.item_image)
                itemTitle = itemView.findViewById(R.id.item_title)
                itemDetail = itemView.findViewById(R.id.item_detail)
                itemCost = itemView.findViewById(R.id.item_cost)

            }
        }

        //Set Items from Arrays and Put/Bind them in respectives Views
        override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
            viewHolder.itemTitle.text = titles[i]
            viewHolder.itemDetail.text = details[i]
            viewHolder.itemImage.setImageResource(images[i])
            viewHolder.itemCost.text = cost[i]

            // we have the respective views and corresponding data
            //listen to card clicks
            viewHolder.itemView.setOnClickListener{
                Toast.makeText(context,"Item at Position"+i,Toast.LENGTH_LONG).show()
                //go to BurgerActivity
                if (i == 0){
                    val x = Intent(context, Burger::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(x)
                }
                if (i == 1){
                    val x = Intent(context, fish::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(x)
                }
                if (i == 2){
                    val y = Intent(context, breakfast::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    y.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(y)
                }
                if (i == 3){
                    val m = Intent(context, snacks::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    m.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(m)
                }
                if (i == 4){
                    val n = Intent(context, chinese::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    n.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(n)
                }
                if (i == 5){
                    val a = Intent(context, spaghetti::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(a)
                }
                if (i == 6){
                    val z = Intent(context, Rice::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    z.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(z)
                }
                if (i == 7){
                    val d = Intent(context, Freshy::class.java)
                    //NOTE - RecyclerAdapter is NOT an Activity - class
                    d.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(d)
                }


            }



        }

        // Get how many items the array have, All arrays must have equal sizes
        override fun getItemCount(): Int {
            return titles.size
        }
    }

