package br.team.rest;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.team.rest.Utils.GitHub.GitHubApiClient;
import br.team.rest.Utils.GitHub.GitHubUser;

public class UserDetailActivity extends AppCompatActivity {
    private TextView userInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        userInfoTextView = findViewById(R.id.user_info_text_view);

        String username = getIntent().getStringExtra("USERNAME");
        fetchUserDetails(username);
    }

    private void fetchUserDetails(String username) {
        new Thread(() -> {
            String response = GitHubApiClient.getUserDetails(username);
            runOnUiThread(() -> {
                if (response != null) {
                    Gson gson = new GsonBuilder().create();
                    GitHubUser user = gson.fromJson(response, GitHubUser.class);
                    displayUserInfo(user);
                } else {
                    Toast.makeText(UserDetailActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }

    private void displayUserInfo(GitHubUser user) {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("Name: ").append(user.getName() != null ? user.getName() : "N/A").append("\n\n")

                .append("Login: ").append(user.getLogin() != null ? user.getLogin() : "N/A").append("\n\n")

                .append("Company: ").append(user.getCompany() != null ? user.getCompany() : "N/A").append("\n\n")

                .append("Blog: ").append(user.getBlog() != null ? user.getBlog() : "N/A").append("\n\n")

                .append("Location: ").append(user.getLocation() != null ? user.getLocation() : "N/A").append("\n\n")

                .append("Email: ").append(user.getEmail() != null ? user.getEmail() : "Email não disponível").append("\n\n")

                .append("Bio: ").append(user.getBio() != null ? user.getBio() : "N/A").append("\n\n")

                .append("Public Repos: ").append(user.getPublicRepos()).append("\n").append("\n\n")

                .append("Followers: ").append(user.getFollowers()).append("\n");

        userInfoTextView.setText(userInfo.toString());
    }
}
