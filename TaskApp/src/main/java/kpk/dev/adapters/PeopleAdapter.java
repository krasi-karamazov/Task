package kpk.dev.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kpk.dev.R;
import kpk.dev.models.EmployeeDecorator;
import kpk.dev.models.Manager;
import kpk.dev.models.Worker;
import kpk.dev.utils.Constants;

public class PeopleAdapter extends ArrayAdapter<EmployeeDecorator> {

    private static class ViewHolder{
        TextView tvName;
        TextView tvPoints;
    }

    public PeopleAdapter(Context context, List<EmployeeDecorator> data) {
        super(context, android.R.layout.simple_list_item_1, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;
        if(row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.layout_person_item, parent, false);
            holder = new ViewHolder();
            holder.tvName = (TextView)row.findViewById(R.id.tv_name);
            holder.tvPoints = (TextView)row.findViewById(R.id.tv_points);
            row.setTag(holder);
        }

        holder = (ViewHolder)row.getTag();
        EmployeeDecorator item = getItem(position);
        holder.tvName.setText(Html.fromHtml(item.getHTMLFormattedName()));

        if(getItem(position) instanceof Worker) {
            holder.tvPoints.setText(getContext().getString(R.string.points_string_worker) + ":" + Constants.SCORE_FORMAT.format(((Worker)item).getPoints()));
        }else{
            holder.tvPoints.setText(getContext().getString(R.string.points_string_manager) + ":" + ((Manager)item).getNumberOfSubordinates());
        }
        return row;
    }
}
