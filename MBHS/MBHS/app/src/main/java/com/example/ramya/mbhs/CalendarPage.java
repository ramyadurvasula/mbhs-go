package com.example.ramya.mbhs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
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

    private Calendar currentCalender = Calendar.getInstance(Locale.getDefault());
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMM - yyyy", Locale.getDefault());
    private Map<Date, List<Event>> bookings = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View testview = inflater.inflate(R.layout.calendar_page, null);
        final List<String> mutableBookings = new ArrayList<>();
	TextView textv = (TextView) testview.findViewById(R.id.textview);

        final ListView bookingsListView = (ListView) testview.findViewById(R.id.bookings_listview);
        final Button showPreviousMonthBut = (Button) testview.findViewById(R.id.prev_button);
        final Button showNextMonthBut = (Button) testview.findViewById(R.id.next_button);

        final ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mutableBookings);
        bookingsListView.setAdapter(adapter);
        final CompactCalendarView compactCalendarView = (CompactCalendarView) testview.findViewById(R.id.compactcalendar_view);
        compactCalendarView.drawSmallIndicatorForEvents(true);

        compactCalendarView.setCalendarBackgroundColor(R.color.background_material_light);
        // below allows you to configure color for the current day in the month
        compactCalendarView.setCurrentDayBackgroundColor(getResources().getColor(R.color.colorAccent));
        // below allows you to configure colors for the current day the user has selected
        compactCalendarView.setCurrentSelectedDayBackgroundColor(getResources().getColor(R.color.colorAccent));

        addEvents(compactCalendarView, -1);
        compactCalendarView.invalidate();

        // below line will display Sunday as the first day of the week
        compactCalendarView.setShouldShowMondayAsFirstDay(false);

        //set initial title
//        bar.setText(dateFormatForMonth.format(compactCalendarView.getFirstDayOfCurrentMonth()));

        //set title on calendar scroll
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> bookingsFromMap = bookings.get(dateClicked);
                Log.d("MainActivity", "inside onclick " + dateClicked);
                if(bookingsFromMap != null){
                    Log.d("MainActivity", bookingsFromMap.toString());
                    mutableBookings.clear();
                    for(Event booking : bookingsFromMap){
                        mutableBookings.add(booking.title);
                    }
                    // below will remove events
                    // compactCalendarView.removeEvent(new CalendarDayEvent(dateClicked.getTime(), Color.argb(255, 169, 68, 65)), true);
                    adapter.notifyDataSetChanged();
                }
            }
//            @Override
//            public void onBookingClicked(Event bookingClicked) {
//                mutableBookings.add(bookingClicked.title());
//            }

            @Override
            public void onMonthScroll(Date date) {

            };


//                @Override
//                public void onMonthScroll(Date firstDayOfNewMonth) {
//                    bar.setText(dateFormatForMonth.format(firstDayOfNewMonth));
//                }



        });




        showPreviousMonthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactCalendarView.showPreviousMonth();
            }
        });

        showNextMonthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compactCalendarView.showNextMonth();
		String month = textv.getText();
		switch(month) {
			case “January”:
				textv.setText(“February”);
				break;
			case “February”:
				textv.setText(“March”);
				break;
			case “March”:
				textv.setText(“April”);
				break;
			case “April”:
				textv.setText(“May”);
				break;
			case “May”:
				textv.setText(“June”);
				break;
			case “June”:
				textv.setText(“July”);
				break;
			case “July”:
				textv.setText(“August”);
				break;
			case “August”:
				textv.setText(“September”);
				break;
			case “September”:
				textv.setText(“October”);
				break;
			case “October”:
				textv.setText(“November”);
				break;
			case “November”:
				textv.setText(“December”);
				break;
			case “December”:
				textv.setText(“January”);
				break;
			default:
				compacCalendarView.set(Calendar.MONTH, month);
				textv.setText(May);
		}
            }
        });
        return inflater.inflate(R.layout.calendar_page, container, false);

    }

    private void addEvents(CompactCalendarView compactCalendarView, int month) {
        currentCalender.setTime(new Date());
        currentCalender.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = currentCalender.getTime();
        for(int i = 0; i < 6; i++){
            currentCalender.setTime(firstDayOfMonth);
            if(month > -1){
                currentCalender.set(Calendar.MONTH, month);
            }
            currentCalender.add(Calendar.DATE, i);
            setToMidnight(currentCalender);
            compactCalendarView.addEvent(new CalendarDayEvent(currentCalender.getTimeInMillis(), R.color.accent_material_dark,  "Event " + i, "test " + i), false);
            bookings.put(currentCalender.getTime(), createBookings());
        }
    }

    private List<Event> createBookings() {
        return Arrays.asList(
                new Event(“Test 1", "First test”, “here”, “now”, “forever”, “when”, “then"),
                new Event(“Test 2", "Second test”, “here”, “now”, “forever”, “when”, “then"),
                new Event(“Test 3", "Third test”, “here”, “now”, “forever”, “when”, “then"));
    }

    private void setToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }


}