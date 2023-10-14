-- createpage pagese:- 
INSERT INTO public.pages(
	pageid, pagelabel, structure)
	VALUES (?, ?, ?);


--update-pagestructure
UPDATE public.pages
	SET pageid=?, pagelabel=?, structure=?
	WHERE pageid=?;

-- delete-page
DELETE FROM public.components
	WHERE page_id = ?;
DELETE FROM public.pages
	WHERE pageid = ?;


-- update-component
UPDATE public.components
	SET page_id=?, component_id=?, component_label=?, data=?, component_styles=?
	WHERE page_id=? and component_id=?;


-- delete-component

DELETE FROM public.components
	WHERE component_id = ?;

    -- create-user
INSERT INTO public.users(
	uid, password, name, clientid, email)
	VALUES (?, ?, ?, ?, ?);



-- update-user
UPDATE public.users
	SET uid=?, password=?, name=?, clientid=?, email=?
	WHERE  uid=?;

    -- delete-user
DELETE FROM public.users
	WHERE  uid=?;

    -- users
    SELECT uid, password, name, clientid, email
	FROM public.users;

    -- pages
    SELECT pageid, pagelabel, structure
	FROM public.pages;



    -- assign-pages
    Delete from public."pages-uid" where pageid = ?
    -- for loop
    INSERT INTO public."pages-uid"(
	uid, pageid)
	VALUES (?, ?);


--assign-pages-table
select * from from public."pages-uid"