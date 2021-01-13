package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewapp.DetailActivity;
import com.example.recyclerviewapp.R;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List listitems)
    {
        this.context = context;
        this.listItems = listitems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        //myadapter.viewholder give access to the viewholderclass of myadapter class
        //so we can access all the items we have intiated in that class
        ListItem item = listItems.get(position);
        //listitems is the object of list which we have initiated in the begining

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {
            //Getting the position of the row clicked or tapped.
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            context.startActivity(intent);
            //Toast.makeText(context,item.getName(),Toast.LENGTH_SHORT).show();
        }
    }
}
