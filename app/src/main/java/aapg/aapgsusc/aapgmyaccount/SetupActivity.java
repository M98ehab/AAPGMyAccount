package aapg.aapgsusc.aapgmyaccount;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText ID, Number, desc;
    private Button btn_save;
    String faculty_str, department_str = "", year_str = "",
            id = "", position_str, coordination_str = "", committee_str = "",
            phone_num, bio;
    AlertDialog.Builder builder;
    private CircleImageView ProfileImage;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        btn_save = (Button) findViewById(R.id.save_info);
        builder = new AlertDialog.Builder(SetupActivity.this);

        ProfileImage = (CircleImageView) findViewById(R.id.setup_profile_image);
        loadingBar = new ProgressDialog(this);


        /*Educational Info*/
        final Spinner faculty = (Spinner) findViewById(R.id.faculty);
        final Spinner department = (Spinner) findViewById(R.id.department);
        final Spinner year = (Spinner) findViewById(R.id.year);

        /*faculties*/
        ArrayAdapter facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty,
                android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(facultyAdapter);

        faculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (faculty.getSelectedItem().toString().equals("Choose your Faculty....")) {
                    department.setVisibility(View.VISIBLE);

                } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.pme_department, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                    /*Science*/
                } else if (faculty.getSelectedItem().toString().equals("Science")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.departmentSC, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Education")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.Education_departments, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.Arts_department, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Computers and Information")) {
                    department.setVisibility(View.GONE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.year4, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Economics and Politics Science")) {
                    department.setVisibility(View.GONE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.year4, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.departmentfr, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                    /*Industrial Education*/
                } else if (faculty.getSelectedItem().toString().equals("Industrial Education")) {
                    department.setVisibility(View.GONE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.year4, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);


                } else if (faculty.getSelectedItem().toString().equals("Commerce")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.commerce, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                } else if (faculty.getSelectedItem().toString().equals("Islamic and Arabic Studies")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.islamic, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                } else if (faculty.getSelectedItem().toString().equals("High Canal Institute for Technology and Engineering")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.ma3had, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                } else if (faculty.getSelectedItem().toString().equals("Suez Institute for Management")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.suezInstitutse, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                } else if (faculty.getSelectedItem().toString().equals("Other")) {
                    department.setVisibility(View.VISIBLE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.other_department, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        /*departments*/
        department.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (department.getSelectedItem().toString().equals("Choose your Department ....")) {
                        } else {
                            ArrayAdapter year4Adapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                    R.array.year4, android.R.layout.simple_spinner_dropdown_item);
                            year.setAdapter(year4Adapter);
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


        year.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (year.getSelectedItem().toString().equals("Choose the year...")) {
                        } else {
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        /*Chapter Info*/

        final Spinner Position = (Spinner) findViewById(R.id.position);
        final Spinner coordination = (Spinner) findViewById(R.id.coordination);
        final Spinner committee = (Spinner) findViewById(R.id.committee);
        ID = (EditText) findViewById(R.id.id);

        ArrayAdapter PositionAdapter = ArrayAdapter.createFromResource(this, R.array.position,
                android.R.layout.simple_spinner_dropdown_item);
        Position.setAdapter(PositionAdapter);

        Position.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (Position.getSelectedItem().toString().equals("Choose your Position....")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);

                } else if (Position.getSelectedItem().toString().equals("Member")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);


                } else if (Position.getSelectedItem().toString().equals("Head Assistant")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex Head Assistant")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);


                } else if (Position.getSelectedItem().toString().equals("Head")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex Head")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);


                } else if (Position.getSelectedItem().toString().equals("Officer")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.GONE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex Officer")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.GONE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);

                } else if (Position.getSelectedItem().toString().equals("Vice-officer")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("President")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex President")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Vice-president")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex Vice-president")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Programs Coordinator")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Trainer")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Ex Trainer")) {
                    coordination.setVisibility(View.GONE);
                    committee.setVisibility(View.GONE);

                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);


                } else if (Position.getSelectedItem().toString().equals("Editor-In-Chief")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                } else if (Position.getSelectedItem().toString().equals("Ex Editor-In-Chief")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.VISIBLE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordination, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                } else if (Position.getSelectedItem().toString().equals("Secretary Deputy")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.GONE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordinationsec, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);

                } else if (Position.getSelectedItem().toString().equals("Ex Secretary Deputy")) {
                    coordination.setVisibility(View.VISIBLE);
                    committee.setVisibility(View.GONE);
                    ArrayAdapter coordinationAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.coordinationsec, android.R.layout.simple_spinner_dropdown_item);
                    coordination.setAdapter(coordinationAdapter);

                    ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                            R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                    committee.setAdapter(committeeAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        coordination.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (coordination.getSelectedItem().toString().equals("Choose your coordination...")) {


                        } else if (coordination.getSelectedItem().toString().equals("Marketing Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {

                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.marketing, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);

                            }
                        } else if (coordination.getSelectedItem().toString().equals("Executive Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.executive, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }


                        } else if (coordination.getSelectedItem().toString().equals("HR Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.HR, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }


                        } else if (coordination.getSelectedItem().toString().equals("Academy Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.academy, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }


                        } else if (coordination.getSelectedItem().toString().equals("Secretary Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer") ||
                                    Position.getSelectedItem().toString().equals("Secretary Deputy") ||
                                    Position.getSelectedItem().toString().equals("Ex Secretary Deputy")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.secretary, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }


                        } else if (coordination.getSelectedItem().toString().equals("Treasury Coordination")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.treasury, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }


                        } else if (coordination.getSelectedItem().toString().equals("Other")) {
                            if (Position.getSelectedItem().toString().equals("Officer") ||
                                    Position.getSelectedItem().toString().equals("Ex Officer") ||
                                    Position.getSelectedItem().toString().equals("Vice-officer")) {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.empty, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            } else {
                                ArrayAdapter committeeAdapter = ArrayAdapter.createFromResource(SetupActivity.this,
                                        R.array.other_ccordination, android.R.layout.simple_spinner_dropdown_item);
                                committee.setAdapter(committeeAdapter);
                            }
                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*Personal Info*/
        Number = (EditText) findViewById(R.id.num);
        desc = (EditText) findViewById(R.id.desc);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_save.setVisibility(View.GONE);


                /*Educational Strings*/
                if (faculty.getSelectedItem() != null) {
                    faculty_str = faculty.getSelectedItem().toString().trim();
                }
                if (department.getSelectedItem() != null) {
                    department_str = department.getSelectedItem().toString().trim();
                }
                if (year.getSelectedItem() != null) {
                    year_str = year.getSelectedItem().toString().trim();
                }

                /*Chapter Strings*/
                id = ID.getText().toString().trim();

                if (Position.getSelectedItem() != null) {
                    position_str = Position.getSelectedItem().toString().trim();
                }
                if (coordination.getSelectedItem() != null) {
                    coordination_str = coordination.getSelectedItem().toString().trim();
                }
                if (committee.getSelectedItem() != null) {
                    committee_str = committee.getSelectedItem().toString().trim();
                }

                /*personal Strings*/
                phone_num = Number.getText().toString().trim();
                bio = desc.getText().toString().trim();

                if (bio.equals("")) {
                    bio = "Hey I am Using AAPG MyAccount";
                }


                if (faculty_str.equals("Choose your Faculty....")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your Faculty......");
                    displayBuilder("error");


                } else if (department_str.equals("Choose your Department ....")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your Department......");
                    displayBuilder("error");


                } else if (year_str.equals("Choose the year...")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your Year......");
                    displayBuilder("error");


                } else if (id.equals("")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Enter your ID......");
                    displayBuilder("error");

                } else if (position_str.equals("Choose your Position....")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your position......");
                    displayBuilder("error");

                } else if (coordination_str.equals("Choose your coordination...")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your coordination......");
                    displayBuilder("error");

                } else if (committee_str.equals("Choose your committee...")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Choose your committee......");
                    displayBuilder("error");

                } else if (phone_num.equals("")) {
                    btn_save.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Enter your phone number......");
                    displayBuilder("error");

                }
            }
        });


}

    public void displayBuilder(final String code) {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (code.equals("input error")) {

                } else if (code.equals("reg_success")) {
                    finish();
                } else if (code.equals("reg_failed")) {
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}