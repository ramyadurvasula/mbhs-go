package com.example.ramya.mbhs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Ramya on 3/19/2016.
 */

public class CalendarPage extends Fragment {

    private Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());
    private Map<Date, List<Event>> bookings = new HashMap<>();
    private Event[] arrayOfEvents = new Event[] {
            new Event("Yoga Club is the best club that has ever existed at Blair", "Come do yoga!", "Room 352", "3/26", "3/26", "3:30PM", "4:30PM"),
            new Event("PuzzlePalooza", "Prizes are huge!", "Montgomery Blair HS", "5/18", "5/23", "10:00AM", "12:00PM"),
            new Event("Volleyball Game", "Blair vs. BCC", "Aux. Gym", "4/19", "4/19", "3:00PM", "5:00PM"),
            new Event("Early Release Day", "Dismissal at 1:00 PM", "Montgomery County Public Schools", "4/10", "4/10", "All Day", "All Day"),
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View testview = inflater.inflate(R.layout.calendar_page, null);
        final List<String> mutableBookings = new ArrayList<>();
	    final TextView textv = (TextView) testview.findViewById(R.id.month);
	    final TextView yearv = (TextView) testview.findViewById(R.id.year);

        final ListView bookingsListView = (ListView) testview.findViewById(R.id.bookings_listview);
        final Button showPreviousMonthBut = (Button) testview.findViewById(R.id.prev_button);
        final Button showNextMonthBut = (Button) testview.findViewById(R.id.next_button);

        final ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mutableBookings);
        bookingsListView.setAdapter(adapter);
        final CompactCalendarView ccv = (CompactCalendarView) testview.findViewById(R.id.compactcalendar_view);
        ccv.drawSmallIndicatorForEvents(true);

        ccv.setCalendarBackgroundColor(R.color.background_material_light);
        // below allows you to configure color for the current day in the month
        ccv.setCurrentDayBackgroundColor(getResources().getColor(R.color.colorAccent));
        // below allows you to configure colors for the current day the user has selected
        ccv.setCurrentSelectedDayBackgroundColor(getResources().getColor(R.color.colorAccent));

//        addEvents(ccv, -1);
        ccv.invalidate();

        // below line will display Sunday as the first day of the week
        ccv.setShouldShowMondayAsFirstDay(false);

        //set initial title
        textv.setText(new DateFormatSymbols().getMonths()[Calendar.MONTH]);
	

        //set title on calendar scroll
        ccv.setListener(new CompactCalendarView.CompactCalendarViewListener() {
                                            @Override
                                            public void onDayClick(Date dateClicked) {
                                                List<Event> bookingsFromMap = bookings.get(dateClicked);
                                                Log.d("MainActivity", "inside onclick " + dateClicked);
                                                if (bookingsFromMap != null) {
                                                    Log.d("MainActivity", bookingsFromMap.toString());
                                                    mutableBookings.clear();
                                                    for (Event booking : bookingsFromMap) {
                                                        mutableBookings.add(booking.title);
                                                    }
                                                    // below will remove events
                                                    //
                                                    adapter.notifyDataSetChanged();
                                                } else {
                                                    mutableBookings.clear();
                                                    adapter.notifyDataSetChanged();
                                                }
                                            }
                                            @Override
                                            public void onMonthScroll(Date firstDayOfNewMonth) {
                                                textv.setText(new DateFormatSymbols().getMonths()[firstDayOfNewMonth.getMonth()]);
                                            }
                                        });

        bookingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Event value = (Event) adapter.getItemAtPosition(position);
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("thisEvent", arrayOfEvents[position].toStringArray());
                getContext().startActivity(i);

            }
        });


         showPreviousMonthBut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ccv.showPreviousMonth();
                 String month = (String) textv.getText();
                 switch (month) {
                     case "January":
                         textv.setText("December");
                         break;
                     case "February":
                         textv.setText("January");
                         break;
                     case "March":
                         textv.setText("February");
                         break;
                     case "April":
                         textv.setText("March");
                         break;
                     case "May":
                         textv.setText("April");
                         break;
                     case "June":
                         textv.setText("May");
                         break;
                     case "July":
                         textv.setText("June");
                         break;
                     case "August":
                         textv.setText("July");
                         break;
                     case "September":
                         textv.setText("August");
                         break;
                     case "October":
                         textv.setText("September");
                         break;
                     case "November":
                         textv.setText("October");
                         break;
                     case "December":
                         textv.setText("November");
                         yearv.setText(Integer.parseInt((String) yearv.getText()) - 1);
                         break;
                     default:
                         ccv.setCurrentDate(currentCalendar.getTime());
                         textv.setText(new DateFormatSymbols().getMonths()[Calendar.MONTH]);
                         yearv.setText(currentCalendar.getTime().getYear());
                 }
             }
         });

        showNextMonthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccv.showNextMonth();
	        	String month = (String)textv.getText();
	        	switch(month) {
		    	case "January":
			    	textv.setText("February");
			    	break;
		    	case "February":
		    		textv.setText("March");
		    		break;
		    	case "March":
		    		textv.setText("April");
		    		break;
		    	case "April":
		    		textv.setText("May");
		    		break;
		    	case "May":
		    		textv.setText("June");
		    		break;
		    	case "June":
		    		textv.setText("July");
		    		break;
		    	case "July":
			    	textv.setText("August");
			    	break;
			    case "August":
		    		textv.setText("September");
		    		break;
			    case "September":
			    	textv.setText("October");
			    	break;
			    case "October":
			    	textv.setText("November");
			    	break;
			    case "November":
			    	textv.setText("December");
			    	break;
			    case "December":
			    	textv.setText("January");
			    	yearv.setText(Integer.parseInt((String) yearv.getText()) + 1);
				break;
			default:
                ccv.setCurrentDate(currentCalendar.getTime());
                textv.setText(new DateFormatSymbols().getMonths()[Calendar.MONTH]);
                yearv.setText(currentCalendar.getTime().getYear());
		}
            }
        });
        return inflater.inflate(R.layout.calendar_page, container, false);

    }

    private void addEvents(CompactCalendarView ccv, int month) {
        currentCalendar.setTime(new Date());
        currentCalendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = currentCalendar.getTime();
        for(int i = 0; i < 4; i++){
            currentCalendar.setTime(firstDayOfMonth);
            if(month > -1){
                currentCalendar.set(Calendar.MONTH, month);
            }
            currentCalendar.add(Calendar.DATE, i);
            setToMidnight(currentCalendar);
            ccv.addEvent(new CalendarDayEvent(arrayOfEvents[i]), false);
            bookings.put(currentCalendar.getTime(), createBookings());
        }
    }
    private List<Event> createBookings () {
        List<Event> listOEvents = new ArrayList<Event>(Arrays.asList(arrayOfEvents));
        return listOEvents;
    }

    private void setToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }


}