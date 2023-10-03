package com.bangkitdicoding.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailUserResponse(

	@field:SerializedName("following_url")
	val followingUrl: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("login")
	val login: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("public_repos")
	val publicRepos: Int,

	@field:SerializedName("gravatar_id")
	val gravatarId: String,

	@field:SerializedName("email")
	val email: Any,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String,

	@field:SerializedName("hireable")
	val hireable: Any,

	@field:SerializedName("starred_url")
	val starredUrl: String,

	@field:SerializedName("followers_url")
	val followersUrl: String,

	@field:SerializedName("public_gists")
	val publicGists: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String,

	@field:SerializedName("followers")
	val followers: Int,

	@field:SerializedName("avatar_url")
	val avatarUrl: String,

	@field:SerializedName("events_url")
	val eventsUrl: String,

	@field:SerializedName("html_url")
	val htmlUrl: String,

	@field:SerializedName("following")
	val following: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("location")
	val location: Any,

	@field:SerializedName("node_id")
	val nodeId: String
)
