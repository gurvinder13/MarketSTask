package com.example.marketstask.data.remote.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicRepository implements Parcelable {

    @Expose
    @SerializedName("id")
    public long id;

    @Expose
    @SerializedName("node_id")
    public String nodeId;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("full_name")
    public String fullName;

    @Expose
    @SerializedName("private")
    public Boolean isPrivate;

    @Expose
    @SerializedName("owner")
    public Owner owner;

    @Expose
    @SerializedName("html_url")
    public String htmlUrl;

    @Expose
    @SerializedName("description")
    public String description;

    @Expose
    @SerializedName("fork")
    public String fork;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("forks_url")
    public String forksUrl;

    @Expose
    @SerializedName("keys_url")
    public String keysUrl;

    @Expose
    @SerializedName("collaborators_url")
    public String collaboratorsUrl;

    @Expose
    @SerializedName("teams_url")
    public String teamsUrl;

    @Expose
    @SerializedName("hooks_url")
    public String hooksUrl;

    @Expose
    @SerializedName("issue_events_url")
    public String issueEventsUrl;

    @Expose
    @SerializedName("events_url")
    public String eventsUrl;

    @Expose
    @SerializedName("assignees_url")
    public String assigneesUrl;

    @Expose
    @SerializedName("branches_url")
    public String branchesUrl;

    @Expose
    @SerializedName("tags_url")
    public String tagsUrl;

    @Expose
    @SerializedName("blobs_url")
    public String blobsUrl;

    @Expose
    @SerializedName("git_tags_url")
    public String gitTagsUrl;

    @Expose
    @SerializedName("git_refs_url")
    public String gitRefsUrl;

    @Expose
    @SerializedName("trees_url")
    public String treesUrl;

    @Expose
    @SerializedName("statuses_url")
    public String statusesUrl;

    @Expose
    @SerializedName("languages_url")
    public String languagesUrl;

    @Expose
    @SerializedName("stargazers_url")
    public String stargazersUrl;

    @Expose
    @SerializedName("contributors_url")
    public String contributorsUrl;

    @Expose
    @SerializedName("subscribers_url")
    public String subscribersUrl;

    @Expose
    @SerializedName("subscription_url")
    public String subscriptionUrl;

    @Expose
    @SerializedName("commits_url")
    public String commitsUrl;

    @Expose
    @SerializedName("git_commits_url")
    public String gitCommitsUrl;

    @Expose
    @SerializedName("comments_url")
    public String commentsUrl;

    @Expose
    @SerializedName("issue_comment_url")
    public String issueCommentUrl;

    @Expose
    @SerializedName("contents_url")
    public String contentsUrl;

    @Expose
    @SerializedName("compare_url")
    public String compareUrl;

    @Expose
    @SerializedName("merges_url")
    public String mergesUrl;

    @Expose
    @SerializedName("archive_url")
    public String archiveUrl;

    @Expose
    @SerializedName("downloads_url")
    public String downloadsUrl;

    @Expose
    @SerializedName("issues_url")
    public String issuesUrl;

    @Expose
    @SerializedName("pulls_url")
    public String pullsUrl;

    @Expose
    @SerializedName("milestones_url")
    public String milestonesUrl;

    @Expose
    @SerializedName("notifications_url")
    public String notificationsUrl;

    @Expose
    @SerializedName("labels_url")
    public String labelsUrl;

    @Expose
    @SerializedName("releases_url")
    public String releasesUrl;

    @Expose
    @SerializedName("deployments_url")
    public String deploymentsUrl;

    public static DiffUtil.ItemCallback<PublicRepository> DIFF_CALLBACK = new DiffUtil.ItemCallback<PublicRepository>() {
        @Override
        public boolean areItemsTheSame(@NonNull PublicRepository oldItem, @NonNull PublicRepository newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull PublicRepository oldItem, @NonNull PublicRepository newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected PublicRepository(Parcel in) {
        id = in.readLong();
        nodeId = in.readString();
        name = in.readString();
        fullName = in.readString();
        byte tmpIsPrivate = in.readByte();
        isPrivate = tmpIsPrivate == 0 ? null : tmpIsPrivate == 1;
        htmlUrl = in.readString();
        description = in.readString();
        fork = in.readString();
        url = in.readString();
        forksUrl = in.readString();
        keysUrl = in.readString();
        collaboratorsUrl = in.readString();
        teamsUrl = in.readString();
        hooksUrl = in.readString();
        issueEventsUrl = in.readString();
        eventsUrl = in.readString();
        assigneesUrl = in.readString();
        branchesUrl = in.readString();
        tagsUrl = in.readString();
        blobsUrl = in.readString();
        gitTagsUrl = in.readString();
        gitRefsUrl = in.readString();
        treesUrl = in.readString();
        statusesUrl = in.readString();
        languagesUrl = in.readString();
        stargazersUrl = in.readString();
        contributorsUrl = in.readString();
        subscribersUrl = in.readString();
        subscriptionUrl = in.readString();
        commitsUrl = in.readString();
        gitCommitsUrl = in.readString();
        commentsUrl = in.readString();
        issueCommentUrl = in.readString();
        contentsUrl = in.readString();
        compareUrl = in.readString();
        mergesUrl = in.readString();
        archiveUrl = in.readString();
        downloadsUrl = in.readString();
        issuesUrl = in.readString();
        pullsUrl = in.readString();
        milestonesUrl = in.readString();
        notificationsUrl = in.readString();
        labelsUrl = in.readString();
        releasesUrl = in.readString();
        deploymentsUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nodeId);
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeByte((byte) (isPrivate == null ? 0 : isPrivate ? 1 : 2));
        dest.writeString(htmlUrl);
        dest.writeString(description);
        dest.writeString(fork);
        dest.writeString(url);
        dest.writeString(forksUrl);
        dest.writeString(keysUrl);
        dest.writeString(collaboratorsUrl);
        dest.writeString(teamsUrl);
        dest.writeString(hooksUrl);
        dest.writeString(issueEventsUrl);
        dest.writeString(eventsUrl);
        dest.writeString(assigneesUrl);
        dest.writeString(branchesUrl);
        dest.writeString(tagsUrl);
        dest.writeString(blobsUrl);
        dest.writeString(gitTagsUrl);
        dest.writeString(gitRefsUrl);
        dest.writeString(treesUrl);
        dest.writeString(statusesUrl);
        dest.writeString(languagesUrl);
        dest.writeString(stargazersUrl);
        dest.writeString(contributorsUrl);
        dest.writeString(subscribersUrl);
        dest.writeString(subscriptionUrl);
        dest.writeString(commitsUrl);
        dest.writeString(gitCommitsUrl);
        dest.writeString(commentsUrl);
        dest.writeString(issueCommentUrl);
        dest.writeString(contentsUrl);
        dest.writeString(compareUrl);
        dest.writeString(mergesUrl);
        dest.writeString(archiveUrl);
        dest.writeString(downloadsUrl);
        dest.writeString(issuesUrl);
        dest.writeString(pullsUrl);
        dest.writeString(milestonesUrl);
        dest.writeString(notificationsUrl);
        dest.writeString(labelsUrl);
        dest.writeString(releasesUrl);
        dest.writeString(deploymentsUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PublicRepository> CREATOR = new Creator<PublicRepository>() {
        @Override
        public PublicRepository createFromParcel(Parcel in) {
            return new PublicRepository(in);
        }

        @Override
        public PublicRepository[] newArray(int size) {
            return new PublicRepository[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        PublicRepository repo = (PublicRepository) obj;
        return repo.id == this.id;
    }

}
